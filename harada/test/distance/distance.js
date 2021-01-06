distance();

function distance(){
// データリスト、東京都のラーメン＆つけ麺
    // 緯度経度取得後に、各データ毎にlat(緯度),lng(経度)が入ります。
    var dataList = [
        {
            "name": "麺処くるり市ヶ谷店",
            "address": "東京都新宿区市谷田町3-2"
        },
        {
            "name": "SOBAHOUSE 不如帰",
            "address": "東京都渋谷区幡ヶ谷2-47-12"
        },
        {
            "name": "狼煙屋",
            "address": "東京都東大和市清水6-1257-17"
        },
        {
            "name": "中華そば 春木屋",
            "address": "東京島豊島区南池袋2-42-8"
        },
        {
            "name": "五ノ神製作所",
            "address": "東京都渋谷区千駄ヶ谷5-33-16"
        },
        {
            "name": "一燈",
            "address": "東京都葛飾区東新小岩1-4-17"
        },
        {
            "name": "道",
            "address": "東京都葛飾区亀有5-28-17"
        },
        {
            "name": "こうかいぼう",
            "address": "東京都江東区深川2-13-10-101"
        },
        {
            "name": "田中商店",
            "address": "東京都足立区一ツ家2-14-6"
        },
        {
            "name": "Japanese Soba Noodle 蔦",
            "address": "東京都豊島区巣鴨1-14-1"
        },
        {
            "name": "中華ソバ みなみ",
            "address": "東京都板橋区前野町4-58-10"
        }
    ];


navigator.geolocation.getCurrentPosition( successFunc , errorFunc , optionObj ) ;
    // データリストの緯度経度を取得
    function dfdGeocode(){
        var dfd = $.Deferred();


        // Geocoderのインスタンスを生成
        var geocoder = new google.maps.Geocoder();

        // カウンター
        var cnt = 0;

        // データ分緯度経度の取得
        $.each(dataList, function(i, data){
            geocoder.geocode({
                address: data.address
            }, function(d, status){
                data.lat = d[0].geometry.location.lat(); //緯度
                data.lng = d[0].geometry.location.lng(); //経度
                cnt++;
                if( cnt === dataList.length ){
                    dfd.resolve();
                }
            });
        });

        return dfd.promise();
    }


    // 現在位置の取得
    function dfdCurrentPosition(){
        var dfd = $.Deferred();

        // Geolocationが使用可能かチェック
        if( !window.navigator.geolocation ) dfd.reject();

        // 現在地の取得
        window.navigator.geolocation.getCurrentPosition(
            // Success
            function(position){
                dfd.resolve(position);
            },
            // Error
            function(error){
                dfd.reject();
            },
            // Options
            {
                enableHighAccuracy:true, //位置情報の精度を高く
                timeout: 10000, //10秒でタイムアウト
                maximumAge: 600000 //10分間有効
            }
        );

        return dfd.promise();
    }


    // DOM Content Loaded
    function dfdDocumentReady(){
        var dfd = $.Deferred();
        $(function(){
            dfd.resolve($(document));
        });
        return dfd.promise();
    }


    // データが揃った段階でソートを開始
    $.when(
        dfdCurrentPosition(),
        dfdGeocode(),
        dfdDocumentReady()
    )
    .done(function(position){

        // 現在地
        var coords = position.coords;

        // 距離の割り出しを行ない、各データにdistance属性を設定
        $.each(dataList, function(i, data){
            data.distance = getDistance(data.lat, data.lng, coords.latitude, coords.longitude, 0) / 1000; //kmで算出
        });

        // 現在地からの距離が小さい順にソート
        dataList.sort(function(a, b){
            return (a.distance < b.distance) ? -1 : 1;
        });

        // データを出力
        var html =  "";

        $.each(dataList, function(i, data){
            html += '<tr>';
                html += '<td>'+(i+1)+'</td>';
                html += '<td><a href="https://maps.google.co.jp/maps?q='+data.lat+','+data.lng+'&z=17&iwloc=A" target="_blank">';
                    html += data.name;
                html += '</a></td>';
                html += '<td>'+data.distance+'km</td>';
            html += '</tr>';
        });

        $("#data-list").append(html);

    })
    .fail(function(){
        alert("お使いの端末の位置情報サービスが無効になっているか対応していないため、エラーが発生しました");
        console.log("error", arguments);
    });


    /**
     * 2点間の緯度経度から距離を取得
     * 測地線航海算法を使用して距離を算出する。
     * @see http://hamasyou.com/blog/2010/09/07/post-2/
     * @param float 緯度1
     * @param float 経度2
     * @param float 緯度2
     * @param float 経度2
     * @param 小数点以下の桁数(べき乗で算出精度を指定)
     */
    function getDistance(lat1, lng1, lat2, lng2, precision){
      var distance = 0;
      if( ( Math.abs(lat1 - lat2) < 0.00001 ) && ( Math.abs(lng1 - lng2) < 0.00001 ) ) {
        distance = 0;
      }else{
        lat1 = lat1 * Math.PI / 180;
        lng1 = lng1 * Math.PI / 180;
        lat2 = lat2 * Math.PI / 180;
        lng2 = lng2 * Math.PI / 180;

        var A = 6378140;
        var B = 6356755;
        var F = ( A - B ) / A;

        var P1 = Math.atan( ( B / A ) * Math.tan(lat1) );
        var P2 = Math.atan( ( B / A ) * Math.tan(lat2) );

        var X = Math.acos( Math.sin(P1) * Math.sin(P2) + Math.cos(P1) * Math.cos(P2) * Math.cos(lng1 - lng2) );
        var L = ( F / 8 ) * ( ( Math.sin(X) - X ) * Math.pow( (Math.sin(P1) + Math.sin(P2) ), 2) / Math.pow( Math.cos(X / 2), 2 ) - ( Math.sin(X) - X ) * Math.pow( Math.sin(P1) - Math.sin(P2), 2 ) / Math.pow( Math.sin(X), 2) );

        distance = A * ( X + L );
        var decimal_no = Math.pow(10, precision);
        distance = Math.round(decimal_no * distance / 1) / decimal_no;
      }
	console.log(distance);
      return distance;
    }
}
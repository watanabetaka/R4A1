cmanPosGet();

// ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
//
//  【 現在地の取得サンプル 】  http://www.cman.jp
//
//     cmanPosGet() を実行すると、現在位置の取得を行います。
//
//     【デモ用】の箇所は、でも（サンプル）の表示用です。
//      このため、使用に合わせた変更が必要です。
//
//   商用,改変,再配布はすべて自由ですですが、動作保証はありません
//
// ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

//==================================================================================================
//  位置取得 成功時に実行される
//==================================================================================================
function cmanGetOk(argPos){

    // --- 取得した値を出力 ------------------------------------------------------------------------
    document.getElementById("getLatitude").innerHTML         = argPos.coords.latitude;          // 緯度
    document.getElementById("getLongitude").innerHTML        = argPos.coords.longitude;         // 経度
    document.getElementById("getAccuracy").innerHTML         = argPos.coords.accuracy;          // 緯度・経度の誤差
    document.getElementById("getAltitude").innerHTML         = argPos.coords.altitude;          // 高度
    document.getElementById("getAltitudeAccuracy").innerHTML = argPos.coords.altitudeAccuracy;  // 高度の誤差
    document.getElementById("getHeading").innerHTML          = argPos.coords.heading;           // 方角(0:北)
    document.getElementById("getSpeed").innerHTML            = argPos.coords.speed;             // 速度

    // ---【デモ用】取得した位置の地図リンク編集 ---------------------------------------------------
    document.getElementById("getLocationMap").href = 'http://maps.google.com/maps?q=' + argPos.coords.latitude + ',' + argPos.coords.longitude;

    // ---【デモ用】結果表示制御 -------------------------------------------------------------------
    cmanGetDisplayCtrl('OK');
}


//==================================================================================================
//  位置取得 失敗時に実行される
//==================================================================================================
function cmanGetErr(argErr){
    var wErrMsg = "";
    switch(argErr.code){
        case 1 : wErrMsg = "位置情報の利用が許可されていません";break;
        case 2 : wErrMsg = "デバイスの位置が判定できません";break;
        case 3 : wErrMsg = "タイムアウトしました";break;
    }
    if(wErrMsg == ""){wErrMsg = argErr.message;} 

    // --- エラーメッセージ出力 --------------------------------------------------------------------
    document.getElementById("getErrMag").innerHTML = wErrMsg;

    // ---【デモ用】結果表示制御 -------------------------------------------------------------------
    cmanGetDisplayCtrl('ERR');
}

//==================================================================================================
//  位置取得 実行
//==================================================================================================
function cmanPosGet(){

    // --- ブラウザが対応しているかチェック --------------------------------------------------------
    if (typeof navigator.geolocation === 'undefined') {
        document.getElementById("getErrMag").innerHTML = 'ブラウザが位置情報取得に対応していません';
        cmanGetDisplayCtrl('ERR');
        return false;
    }

    // --- オプション設定 --------------------------------------------------------------------------
    var wOptions = {
        "enableHighAccuracy": true,                       // true : 高精度
        "timeout": 10000,                                 // タイムアウト : ミリ秒
        "maximumAge": 0,                                  // データをキャッシュ時間 : ミリ秒
    };

    // --- 位置取得 --------------------------------------------------------------------------------
    navigator.geolocation.getCurrentPosition(cmanGetOk,   // 位置取得成功時に実行される関数
                                             cmanGetErr,  // 位置取得失敗時に実行される関数
                                             wOptions );  // オプション

    // ---【デモ用】結果表示制御 -------------------------------------------------------------------
    cmanGetDisplayCtrl('START');
    return true;
}

//==================================================================================================
//  【デモ用】結果表示制御 (デモ画面の表示制御用のため、サンプル動作には関係ありません)
//==================================================================================================
function cmanGetDisplayCtrl(argMsg){

    // --- 結果表示制御 ----------------------------------------------------------------------------
    document.getElementById("getOut-area").style.display     = '';
    switch(argMsg){
        case 'OK' :
            document.getElementById("getShorichu").style.display = 'none';
            document.getElementById("getOut-err-area").style.display = 'none';
            document.getElementById("getOut-ok-area").style.display  = '';
            break;
        case 'ERR' :
            document.getElementById("getShorichu").style.display = 'none';
            document.getElementById("getOut-err-area").style.display = '';
            document.getElementById("getOut-ok-area").style.display  = 'none';
            break;
        default :
            document.getElementById("getShorichu").style.display = '';
            document.getElementById("getOut-err-area").style.display = 'none';
            document.getElementById("getOut-ok-area").style.display  = 'none'
            break;
    }

    // --- 結果エリアにゆっくりスクロール ----------------------------------------------------------
    //     https://web-designer.cman.jp/javascript_ref/window/link_scroll/  を参照
    // cmanLinkScroll('getOut-area');
}



function changeCheckbox(idname){
  var obj = document.getElementById(idname);
  obj.checked = !obj.checked;
}

let array_genre = [];/*SortAction.javaに送信*/
let array_city = [];/*SortAction.javaに送信*/
let spot = false;/*SortAction.javaに送信*/

function send() {

  // area_arrayに値を挿入する処理
  // area_nameの個数分ループ
  for (let i=0; i<document.area_form.area_name.length; i++){
    // area_nameにチェックが入っていたら処理を実行
    if(document.area_form.area_name[i]=document.area_form.area_name[i].checked){
      // city_kind クラスから一つずつ、タグに囲まれた文字を取得し、配列に格納
      array_city[i] = document.getElementsByClassName('city_kind')[i].innerHTML ;
      // inputタイプで actions　IDの子要素としてHTML文に追加
      $('#actions').append('<input type="hidden" name="array_city" value="' +array_city[i] +'">');
    }
  }

  // 上記と同様
  for (let i=0; i<document.genre_form.genre_name.length; i++){
    if(document.genre_form.genre_name[i]=document.genre_form.genre_name[i].checked){
      array_genre[i] = document.getElementsByClassName('genre_kind')[i].innerHTML ;
      $('#actions').append('<input type="hidden" name="array_genre" value="' +array_genre[i] +'">');
    }
  }

}

// /*もし位置情報にチェックが入っているなら*/
//   if (document.location_form.location_name.checked){
//     spot = true;
//   }


   /*genre_arra,yarea_array,location_flagをSwipeAction.java に送信*/
      // $('#sendtojava').on('click', function(){
        // $.ajax({
        //   url : 'http://localhost:8080/book/sightseeing_swipe/Sort.action',
        //   type : 'GET',
        //   // data : {array_city : "大分"},
        //   // data : {array_city : "別府"},
        //   // data : {array_city : "由布"},
        //   // data : {array_city : "佐伯"},
        //   // data: {array_city: 1, array_city: 2, array_city: 3},
        //   // data : {array_city : array_city},
        //   //data : {array_genre : array_genre},
        //   // data : {array_genre : "123"},
        //   async: false,
        //   data : {spot : spot, array_city : array_city ,array_genre: array_genre },
        //   traditional: true,
        //   success : function(){
        //     console.log("dddddd");
        //     alert("aaaaaaaaaaa");
        // },
        //   error : function(){
        //     console.log('通信エラーです');
        //   }
        // });

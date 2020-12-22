function changeCheckbox(idname){
  var obj = document.getElementById(idname);
  obj.checked = !obj.checked;
}

let array_genre = [];/*SortAction.javaに送信*/
let array_city = [];/*SortAction.javaに送信*/
let spot = false;/*SortAction.javaに送信*/

function send() {

  /*area_arrayに値を挿入する処理*/
  count=0;
  for (let i=0; i<document.area_form.area_name.length; i++){
    if(document.area_form.area_name[i]=document.area_form.area_name[i].checked){
      array_city[count] = document.getElementsByClassName('area1')[i].innerHTML ; /*大分市等を入れる*/
        $('#actions').append('<input type="hidden" name="array_city" value="' +array_city +'">');
      count = count+1;
    }
  }
}

// $('.actions').eq(0).val("大分市");
// $('.actions').eq(1).val(send_genre());

    // console.log(array_city);


    // console.log(array_city);

function send_genre(){

/*genre_arrayに値を挿入する処理*/
  count=0;
  for (let i=0; i<document.genre_form.genre_name.length; i++){
    if(document.area_form.area_name[i]=document.area_form.area_name[i].checked){
      array_genre[count] = document.getElementsByClassName('genre1')[i].innerHTML ;
      count = count+1;
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

function changeCheckbox(idname){
  var obj = document.getElementById(idname);
  obj.checked = !obj.checked;
}

function send(){
  let array_genre = [];/*SortAction.javaに送信*/
  let array_city = [];/*SortAction.javaに送信*/
  let spot = false;/*SortAction.javaに送信*/

  /*area_arrayに値を挿入する処理*/
    count=0;
    for (let i=0; i<document.area_form.area_name.length; i++){
      if(document.area_form.area_name[i]=document.area_form.area_name[i].checked){
        array_city[count] = document.getElementsByClassName('area1')[i].innerHTML ;/*大分市等を入れる*/
        count = count+1;
        // console.log(array_city[count]);
      }
    }

    console.log(array_city);

/*genre_arrayに値を挿入する処理*/
    count=0;
    for (let i=0; i<document.genre_form.genre_name.length; i++){
      if(document.area_form.area_name[i]=document.area_form.area_name[i].checked){
        array_genre[count] = document.getElementsByClassName('genre1')[i].innerHTML ;
        count = count+1;
      }
    }



/*もし位置情報にチェックが入っているなら*/
  if (document.location_form.location_name.checked){
    spot = true;
  }

   /*genre_arra,yarea_array,location_flagをSwipeAction.java に送信*/
      // $('#sendtojava').on('click', function(){
        $.ajax({
          url : 'http://localhost:8080/book/sightseeing_swipe/Sort.action',
          type : 'GET',
          data : {"array_genre1":["aa","bb"]},
          data : array_city,
          data : {spot : spot},
          success : function(){
            console.log("dddddd");
            alert("aaaaaaaaaaa");
        },
          error : function(){
            console.log('通信エラーです');
          }
        });
 }

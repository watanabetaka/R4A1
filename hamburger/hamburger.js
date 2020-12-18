function changeCheckbox(idname){
  var obj = document.getElementById(idname);
  obj.checked = !obj.checked;
}

function send(){
  const genre_array = [];/*SwipeAction.javaに送信*/
  const area_array = [];/*SwipeAction.javaに送信*/
  var genre_flag = false;
  var area_flag = false;
  var location_info = false;/*SwipeAction.javaに送信*/

  /*console.log("");*/

/*genre_arrayに値を挿入する処理*/
  for (let i=0; i<document.genre_form.genre_name.length; i++){
     genre_flag = false;
    if (elements[i].checked){
      genre_flag = true;
      genre_array[i] =  genre_flag;
    }
  }

/*area_arrayに値を挿入する処理*/
  for (let i=0; i<document.area_form.area_name.length; i++){
     genre_flag = false;
    if (document.area_form.area_name[i].checked){
      area_flag = true;
      area_array[i] =  area_flag;
    }
  }

/*もし位置情報にチェックが入っているなら*/
  if (document.location_form.location_name.checked){
    location_info = true;
  }

  /*genre_arra,yarea_array,location_flagをSwipeAction.java に送信*/
form.submit();
}

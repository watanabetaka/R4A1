count=0;
console.log(array_sightseeing_id);
console.log(array_sightseeing_name);
console.log(array_city_name);
console.log(array_picture_path);

$(document).ready(function(event) {

  addNewProfile();

  function swipe() {
    Draggable.create("#picture_path", {
        throwProps:true,
        onDragEnd:function(endX) {
          if(Math.round(this.endX) > 0 ) {
            swipeLike();
          }
          else {
            swipeDislike();
          }
          console.log(Math.round(this.endX));
      }
    });
  }

  function swipeLike() {

    let request={
      sightseeing_id:array_sightseeing_id[count-1]
    };

    $.ajax({
      type : "GET",
      url  : "http://localhost:8080/book/sightseeing_swipe/favorite_insert",
      data : request,
      async: true,
      error:function(XMLHttpRequest,textStatus,errorThrown){
        alert("エラーが発生し、お気に入りに登録できませんでした。:"+textStatus+errorThrown);
      }

    });

    let picture_path = $("#picture").find('#picture_path');

    let swipe = new TimelineMax({repeat:0, yoyo:false, repeatDelay:0, onComplete:remove, onCompleteParams:[picture_path]});
    swipe.staggerTo(picture_path, 0.8, {bezier:[{left:"+=400", top:"+=300", rotation:"60"}], ease:Power1.easeInOut});

    addNewProfile();
  }

  function swipeDislike() {

    let picture_path = $("#picture").find('#picture_path');

    let swipe = new TimelineMax({repeat:0, yoyo:false, repeatDelay:0, onComplete:remove, onCompleteParams:[picture_path]});
    swipe.staggerTo(picture_path, 0.8, {bezier:[{left:"+=-350", top:"+=300", rotation:"-60"}], ease:Power1.easeInOut});

    addNewProfile();
  }

  function remove(picture_path) {
      $(picture_path).remove();
  }

  function addNewProfile() {

    let sightseeing_name = array_sightseeing_name[count];
    let city_name = array_city_name[count];
    let picture_path = array_picture_path[count];
    if(count !== array_sightseeing_name.length){
      $('#sightseeing_place').html(sightseeing_name);
      $('#city_name').html(city_name);
      $("#picture").prepend('<img id="picture_path" src="'+picture_path+ '">');
    }else{
      $('#sightseeing_place').html("");
      $('#city_name').html("");
      $("#picture").prepend('<div id="no_sightseeing">表示できる観光地はありません</div>');
    }

    count=count+1;


    swipe();
  }

});

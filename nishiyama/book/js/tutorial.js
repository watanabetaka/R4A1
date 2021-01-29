var count=0;
console.log(count);

function countdown(){
  if(count!=0){
    count--;
  }
  console.log(count);
  imgtxtchange();
}

function countup(){
  if(count==5){
    location.href = 'http://10.23.104.32:8080/book/sightseeing_swipe/Swipe.action';
  }else{
    count++;
    console.log(count);
  }
  imgtxtchange();
}

function imgtxtchange(){
  var img = document.getElementById("tutorial_img");
  var txt=document.getElementById("tutorial_txt");

      switch (count) {
        case 0:
          img.src = "../image/41.png";
          txt.innerHTML="そのいち"
          break;
        case 1:
          img.src = "../image/42.png";
          txt.innerHTML="そのに"
          break;
        case 2:
          img.src = "../image/43.png";
          txt.innerHTML="そのさん"
          break;
        case 3:
          img.src = "../image/44.png";
          txt.innerHTML="そのよん"
          break;
        case 4:
          img.src = "../image/45.png";
          txt.innerHTML="そのご"
          break;
        case 5:
          img.src = "../image/46.png";
          txt.innerHTML="そのろく"
          break;
      }
}

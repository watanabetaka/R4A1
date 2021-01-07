console.log(array_sightseeing_name);
console.log(array_city_name);
console.log(array_picture_path);

//最初の観光地を表示
$('#sightseeing_place').html(array_sightseeing_name[0]);
$('#city_name').html(array_city_name[0]);
$('#picture_path').attr('src',array_picture_path[0]);

count=1;

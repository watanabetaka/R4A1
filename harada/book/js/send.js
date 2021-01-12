
function formCheck(){
    var flag = true;
    //企業名が入力されているか確認
    if( document . Form1 . cpname . value == "" ){
        flag = false;
        document . getElementById( 'cpname-null' ) . style . display = "block";
    }else{
        document . getElementById( 'cpname-null' ) . style . display = "none";
    }

    if( document . getElementById( 'sightname' ). value == "" ){
        flag = false;
        document . getElementById( 'sightname-null' ) . style . display = "block";

    }else{
        document . getElementById( 'sightname-null' ) . style . display = "none";
    }

    if( document.getElementById("file").files.length < 1){
        flag = false;
        document . getElementById( 'file-null' ) . style . display = "block";
        console.log(flag);

    }else{
        console.log(document.getElementById("file").files.length);
        document . getElementById( 'file-null' ) . style . display = "none";
    }

    console.log(document . getElementById( 'postal_code' ). value);
    if(document . getElementById( 'postal_code' ). value == ""){
      flag = false;
      console.log(document . getElementById( 'postal_code' ). value);
      document . getElementById( 'postal_code-null' ) . style . display = "block";
    }else if(isNaN(document . getElementById( 'postal_code' ). value)){
              //数字でないか判断
                  flag = false;
                  console.log(document . getElementById( 'postal_code' ). value);
                  document . getElementById( 'postal_code-null' ) . style . display = "none";
                  document . getElementById( 'postal_code-wrong' ) . style . display = "block";
    }else{
                  document . getElementById( 'postal_code-wrong' ) . style . display = "none";
                  document . getElementById( 'postal_code-null' ) . style . display = "none";

    }

    if( document . getElementById( 'address' ). value == "" ){
        flag = false;
        document . getElementById( 'address-null' ) . style . display = "block";

    }else{
        document . getElementById( 'address-null' ) . style . display = "none";
    }

    var tel = document.getElementById('tel').value.replace(/[━.*‐.*―.*－.*\-.*ー.*\-]/gi,'');
    console.log(tel);
    if(tel==""){
      flag = false;
      document . getElementById( 'tel-null' ) . style . display = "block";

    }else if(!tel.match(/^(0[5-9]0[0-9]{8}|0[1-9][1-9][0-9]{7})$/)){
                  flag = false;
                  document . getElementById( 'tel-null' ) . style . display = "none";
                  document . getElementById( 'tel-wrong' ) . style . display = "block";
    }else{
                  document . getElementById( 'tel-wrong' ) . style . display = "none";
    }

    if( document . getElementById( 'business_hour' ). value == "" ){
        flag = false;
        document . getElementById( 'business_hour-null' ) . style . display = "block";

    }else{
        document . getElementById( 'business_hour-null' ) . style . display = "none";
    }

    if( document . getElementById( 'station' ). value == "" ){
        flag = false;
        console.log(flag);
        document . getElementById( 'station-null' ) . style . display = "block";

    }else{
        console.log(flag);
        document . getElementById( 'station-null' ) . style . display = "none";
    }

    if(!flag ){
      console.log(flag);
      window . alert( '必須項目は全て入力していないか、入力方式が間違っています。' );
      return false;
    }else{
      return true;
    }
}

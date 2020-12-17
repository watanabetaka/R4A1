$(document).ready(function()
{
	/** ②指が触れたか検知 */
	$("#picture_path").on("touchstart", start_check);

	/** ③指が動いたか検知 */
	$("#picture_path").on("touchmove", move_check);

	/** ④指が離れたか検知 */
	$("#picture_path").on("touchend", end_check);

	/** 変数宣言 */
	let moveY,modeX, posiY, posiX;

	// ⑤タッチ開始時の処理
	function start_check(event)
	{
		/** 現在の座標取得 */
		posiY = getY(event);
		posiX = getX(event);

		/** 移動距離状態を初期化 */
		moveY = '';
		moveX = '';

		/** 表示メッセージを初期化 */
		msgY = '';
		msgX = '';
	}

	// ⑥スワイプ中の処理
	function move_check(event)
	{
		if (posiX - getX(event) > 70) // 70px以上移動でスワイプと判断
		{
			/** 右→左と判断 */
			moveX = "left";
		}
		else if (posiX - getX(event) < -70)  // 70px以上移動でスワイプと判断
		{
			/** 左→右と判断 */
			moveX = "right";
		}

		if (posiY - getY(event) > 70) // 70px以上移動でスワイプと判断
		{
			/** 下→上と判断 */
			moveY = "top";
		}
		else if (posiY - getY(event) < -70)  // 70px以上移動でスワイプと判断
		{
			/** 上→下と判断 */
			moveY = "bottom";
		}
	}

	// ⑦指が離れた時の処理
	function end_check(event)
	{

    // 左スワイプの時の処理
		if (moveX == "left")
		{
      if(count!=array_sightseeing_name.length){
  			$('#sightseeing_place').html(array_sightseeing_name[count]);
				$('#city_name').html(array_city_name[count]);
        $('#picture_path').attr('src',array_picture_path[count]);
      }else{
        $('#sightseeing_place').html("");
        $('#picture_path').attr('src',"");
        $('#picture').html("表示できる観光地はありません");
      }
		}

    // 右スワイプの時の処理
		else if (moveX == "right")
		{
      if(count!=array_sightseeing_name.length){
  			$('#sightseeing_place').html(array_sightseeing_name[count]);
				$('#city_name').html(array_city_name[count]);
        $('#picture_path').attr('src',array_picture_path[count]);
      }else{
        $('#sightseeing_place').html("");
        $('#picture_path').attr('src',"");
        $('#picture').html("表示できる観光地はありません");
      }
		}

    count=count+1;

		if (moveY == "top")
		{
			msgY = "上へ移動";
		}
		else if (moveY == "bottom")
		{
			msgY = "下へ移動";
		}

	}


	// 座標取得処理
	function getY(event)
	{
		//縦方向の座標を取得
		return (event.originalEvent.touches[0].pageY);
	}

	function getX(event)
	{
		//横方向の座標を取得
		return (event.originalEvent.touches[0].pageX);
	}


});

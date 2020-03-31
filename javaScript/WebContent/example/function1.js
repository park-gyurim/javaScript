var num = 1;
        
        //변수값이 null, 0 -> 거짓(false)
        //변수값이 있거나, "값" ->참(true)
        function gellery(direct) {
        	if(direct) {//증가
        		if(num==4)
        			return;
        	num++;
        	}else{//감소
        		if(num ==1)
        			return;
        	num--;
        	}
            var photo = document.getElementById('photo');
            photo.setAttribute("src","../image/" + num + ".jpg");
        }
        var photoElement = document.getElementById('photo');
        console.log(photoElement);
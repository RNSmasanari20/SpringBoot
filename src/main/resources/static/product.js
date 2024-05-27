'use strict';

    fetch(`/api/products`)
      .then(res => {
        if(res.status === 400) {
          document.getElementById('id').textContent = "";
          document.getElementById('name').textContent = "";
          document.getElementById('price').textContent = "";
        } else {
            res.json()
            .then(data => {

            const trTh = document.createElement('tr');

            const thId = document.createElement('th');
            thId.textContent = 'id';
            trTh.appendChild(thId);

            const thName = document.createElement('th');
            thName.textContent = '名前';
            trTh.appendChild(thName);

            const thPrice = document.createElement('th');
            thPrice.textContent = '値段';
            trTh.appendChild(thPrice);

            document.getElementById('tableMain').appendChild(trTh);

            for(let i=0; i<data.length; i++){

            let trCon = document.createElement('tr');

            let trId = document.createElement('tr');
            trId.textContent = data[i].id;
            trCon.appendChild(trId);

            let input_radio = document.createElement("input");
            input_radio.type = "radio";
            input_radio.name = "product_radio";
            trId.appendChild(input_radio);

            let trName = document.createElement('th');
            trName.textContent = data[i].name;
            trCon.appendChild(trName);

            let trPrice = document.createElement('th');
            trPrice.textContent = data[i].price;
            trCon.appendChild(trPrice);

            document.getElementById('tableMain').appendChild(trCon);
             }
            })
        }
      });
'use strict';

let destinations = [];
//fetch mockeado
function fetchMockedData() {
  fetch('./mockedResponses/destinations.json')
    .then(response => response.json())
    .then(data => {
        destinations = data.destinations;
        console.log('JSON:::',destinations)
        //processData();
    })
    .catch(error => console.error('Error fetching JSON:', error));
}


//fetch a la bd
function fetchData() {
      fetch('destinationsData')
        .then(response => response.json())
        .then(data => console.log('DB:::', data))
        .catch(error => console.error('Error fetching JSON:', error));
}

    window.onload = function() {
      fetchData();
      fetchMockedData();
    }

/*código para coger los usuarios en AJAX puro, usando fetch hay cosas que no se hacen
window.onload = function () {
  let user;
  let xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4) {
      if (xhr.status === 200) {
        try {
          user = JSON.parse(xhr.responseText);

          //document.getElementById('user').innerHTML = user.???
        } catch (e) {
          //TODO: handle exception
          location.href = "que html???"
        }
      }
    }
  };

  xhr.open("GET", "??", false);
  xhr.setRequestHeader("Content-type", "application/json");
  xhr.send()
} */

//Para pintar la información requerida acerca del planeta
// function processData() {
//     const destinationsNames = document.querySelector('#destinationsNames');
//     const destinationContainer = document.querySelector('#destination');

//     destinations.forEach(destination => {
//       //Para pintar los nombres de los planetas
//         let destinationName = document.createElement("li");
//         destinationName.id = destination.name;
//         destinationName.classList.add("planet");
//         destinationName.addEventListener("click", (e) => {
//           const et = e.target;
//           //addd active class
//           const active = document.querySelector(".active");
//           //when btn clicked, removed active class
//           if (active) {
//             active.classList.remove("active")
//           }
//           //add active class to the clicked btn
//           et.classList.add("active");
//           //select all clases with the name content
//           let allContent = document.querySelectorAll('.content');
//           //loop through all content class
//           for (let content of allContent) {
//             //display the content if the value coincides
//             if (content.id === destinationName.id) {
//               content.computedStyleMap.display = "block";
//             } else {
//               content.style.display = "none";
//             }
//           }
//         })
//         destinationName.innerHTML = `
//         <button>
//           ${destination.name}
//         </button>
//         `;
//         destinationsNames.appendChild(destinationName);
//     })
// }
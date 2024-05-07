'use strict';

let destinations = [];

/*fetch('./mockedResponses/destinations.json') /*aquí se cambiará por la llamada al back -> bbdd 
    .then(response => response.json())
    .then(data => {
        destinations = data.destinations;
        processData();
    })
    .catch(error => console.error('Error fetching JSON:', error));*/

function fetchData() {
      fetch('destinationsData')
        .then(response => response.json())
        .then(data => console.log(data))
        .catch(error => console.error('Error fetching JSON:', error));
    }
    
    // function pintar(results) {
    //   console.log(results)
    // }
    
    window.onload = function() {
      fetchData();
    }
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

//       //Para pintar la información requerida acerca del planeta
//         let newDestination = document.createElement("div");
//         newDestination.id = destination.name;
//         newDestination.classList.add("content");
//         newDestination.innerHTML = `
//         <p class="destination__container--text--main-title">
//           ${destination.name}
//         </p>
//         <p class="destination__container--text--paragraph">
//           ${destination.description}
//         </p>
//         <div class="destination__container--text--rectangle"></div>
//         <div class="container__div--info">
//           <div class="div__info">
//             <p class="info-travel">Avg. distance</p>
//             <p class="info-distance">${destination.distance}</p>
//           </div>
//           <div class="div__info">
//             <p class="info-travel">Est. travel time</p>
//             <p class="info-distance">${destination.travel}</p>
//           </div>
//         </div>
//         `;
//         destinationContainer.appendChild(newDestination);
//     })
// }

// function fetchData() {
//   fetch(destinationsData)
//     .then(response => response.json())
//     .then(data => pintar(data))

// }

// function pintar(results) {
//   console.log(results)
// }

// window.onload = function() {
//   fetchData();
// }
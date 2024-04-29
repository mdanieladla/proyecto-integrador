'use strict';
/* https://www.youtube.com/watch?v=ZleShIpv5zQ SPA */
/* ---------------------- SPA -----------------------------*/
//Función que va a manejar el comportamiento por defecto del link y los cambios de ubicación
// const route = (event) => {
//     event = event || window.event; //Capturar el click event del link
//     event.prventDefault(); //Llamada a preventDefault para evitar el comportamiento por defecto del link
//     window.history.pushState({}, "", event.target.href); //Usamos la API history del navegador llamando a pushState() y pasando los valores href como 3er arg. Esto actualizará la URL en el navegador.
//     handleLocation(); //Llamada aquí hará que se cargue la ruta de nuestra aplicación en lugar del comportamiento por defecto de los enlaces.
// };
// //Definimos algunas rutas para el path
// const routes = {
//     404: "/pages/notfound.html",
//     "/": "/index.html",
//     "/destinations": "/pages/destinations.html",
//     "/crew": "/pages/crew.html",
//     "/technology": "/pages/technology.html",
// }
// //Función para manejar la ubicación que será llamada cada vez que se navegue por la app
// const handleLocation = async () => {
//     try {
//         const path = window.location.pathname; //Capturamos pathname de la ubicación actual
//         const route = routes[path] || routes[404]; //Usamos pathname para encontrar la ruta deseada o redirigir a 404 si no existe la ruta
//         const response = await fetch(route);
//         if (!response.ok) {
//             throw new Error(`Error fetching route: ${route}`);
//         }
//         const html = await response.text(); //Cargamos el html para la ruta
//         document.getElementById('main-page').innerHTML = html; //Se asigna el html que queremos cargar al HTML de la página
//     } catch (error) {
//         console.log(error)
//     }
// }
// // Manejar enrutamiento del navegador y la primera carga de la página
// window.onpopstate = handleLocation; //Para manejar cuando se pulsan los botones de atrás y siguiente
// window.route = route; //Para darle acceso global a la función route.

// handleLocation(); //Llamada en la carga de la página para carga la página correcta para cualquier ruta en la que el usuario llegue primero

/* ---------------------- Menú mobile version -----------------------------*/
//Traemos elemntos del HTML
const navMenu = document.querySelector('.jsNavMenu');
const navClose = document.querySelector('.jsCloseIcon');
const navOpen = document.querySelector('.jsOpenMenu');

/* ------- SHOW MENU ------ */
/*Validamos si la constante existe*/
if (navClose) {
    navClose.addEventListener('click', () => {
        navMenu.classList.remove('show-menu')
    })
}

if (navOpen) {
    navOpen.addEventListener('click', () => {
        navMenu.classList.add('show-menu')
    })
}

/* ---------------------- Form validation -----------------------------*/
const form = document.querySelector('.js-form');

const firstName = document.querySelector('.js-first-name');
const email = document.querySelector('.js-email');
const password = document.querySelector('.js-password');
const firstNameErr = document.querySelector('.js-first-name-err');
const emailErr = document.querySelector('.js-email-err');
const passErr = document.querySelector('.js-pass-err');

function fillData() {
  if (firstName === '') {
    return (firstNameErr.innerHTML = "Name can't be empty");
  } else {
    return;
  }
}

const validateName = () => {
  const nameValue = firstName.value.trim();

  if (nameValue === '') {
    return (firstNameErr.innerHTML = "Name can't be empty");
  } else {
  }
};

const validateEmail = () => {
  const emailValue = email.value.trim();

  if (emailValue === '') {
    return (emailErr.innerHTML = "Email can't be empty");
  }
};

const validatePassword = () => {
  const passValue = password.value.trim();

  if (passValue === '') {
    return (passErr.innerHTML = "Password can't be empty");
  }
};

// form.addEventListener('submit', (ev) => {
//   ev.preventDefault();

//   validateName();
//   validateEmail();
//   validatePassword();
// });

// firstName.addEventListener('focusout', () => {
//   validateName();
// });

// email.addEventListener('focusout', () => {
//   validateEmail();
// });
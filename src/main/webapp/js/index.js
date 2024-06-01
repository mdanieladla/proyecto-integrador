'use strict';
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
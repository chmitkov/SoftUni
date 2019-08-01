(function () {
  let template = document.getElementById('monkey-template').innerHTML;
  let compiled = Handlebars.compile(template);

  let rendered = compiled({ monkeys });
  document.getElementById('m').innerHTML = rendered;

  Array.from(document.getElementsByTagName('button'))
    .forEach(b => b.addEventListener('click', showInfo));


  function showInfo() {
    let pElement = this.parentNode
      .querySelector('p');

    pElement.style.display === 'none'
      ? pElement.style.display = 'block'
      : pElement.style.display = 'none';s
  }
})();
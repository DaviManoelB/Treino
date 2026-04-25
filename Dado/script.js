const resultadoDados = document.querySelector('.resultado-dados');
const buttons = document.querySelectorAll('.rodar');

const lado = {
  d2: 2,
  d4: 4,
  d6: 6,
  d8: 8,
  d10: 10,
  d12: 12,
  d20: 20,
  d100: 100,
};

function rolar(sides) {
  return Math.floor(Math.random() * sides) + 1;
}

function formatRollResult(diceName, quantity, rolls) {
  const sum = rolls.reduce((total, value) => total + value, 0);
  const rollList = rolls.join(' + ');
  return `
    <div class="roll-result">
      <div> ${diceName.toUpperCase()} x ${quantity}</div>
      <div> ${rollList}</div>
      <div>Total: ${sum}</div>
    </div>
  `;
}

buttons.forEach(button => {
  button.addEventListener('click', () => {
    const article = button.closest('article');
    if (!article) return;

    const dado = article.querySelector('h3')?.textContent.trim().toLowerCase();
    const select = article.querySelector('select[name="quantidade"]');
    const quantity = Number(select?.value || 1);

    if (!dado || !lado[dado]) return;
    if (quantity < 1) return;

    const sides = lado[dado];
    const rolls = Array.from({ length: quantity }, () => rolar(sides));
    const html = formatRollResult(dado, quantity, rolls);

    resultadoDados.innerHTML = html;
  });
});

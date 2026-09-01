let display = document.getElementById('display');
let historyDiv = document.getElementById('history');

function appendToDisplay(value) {
    display.value += value;
}

function clearDisplay() {
    display.value = '';
}

function deleteLastChar() {
    display.value = display.value.slice(0, -1);
}

function calculate() {
    let expression = display.value;

    if (!expression.trim()) {
        alert('Veuillez entrer une expression');
        return;
    }

    fetch('/api/calculator/calculate', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            expression: expression
        })
    })
    .then(response => response.json())
    .then(data => {
        if (data.error) {
            alert('Erreur : ' + data.error);
        } else {
            display.value = data.result;
            addToHistory(expression, data.result);
        }
    })
    .catch(error => {
        alert('Erreur : ' + error.message);
    });
}

function addToHistory(expression, result) {
    let historyItem = document.createElement('div');
    historyItem.className = 'history-item';
    historyItem.textContent = expression + ' = ' + result;
    historyDiv.appendChild(historyItem);

    if (historyDiv.children.length > 10) {
        historyDiv.removeChild(historyDiv.firstChild);
    }
}

document.addEventListener('keydown', function(event) {
    if (event.key === 'Enter') {
        calculate();
    } else if (event.key === 'Escape') {
        clearDisplay();
    } else if (event.key === 'Backspace') {
        deleteLastChar();
    }
});
// static/js/script.js
function greet() {
    var name = document.getElementById('name').value;
    fetch('/api/greet', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ 'name': name })
    })
    .then(response => response.json())
    .then(data => {
        document.getElementById('response').innerText = data.message;
    });
}

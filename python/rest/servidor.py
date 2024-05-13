# app.py - Servidor Flask
from flask import Flask, render_template, request, jsonify

app = Flask(__name__)

# Ruta para la página principal
@app.route('/')
def index():
    return render_template('index.html')

# Ruta para el endpoint API
@app.route('/api/greet', methods=['POST'])
def greet():
    data = request.get_json()
    name = data.get('name', 'Mundo')
    return jsonify({'message': f'Hola, {name}!'})

if __name__ == '__main__':
    app.run(debug=True)

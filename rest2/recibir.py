from flask import Flask, request, send_from_directory, jsonify
import os

app = Flask(__name__)

# Directorio donde se almacenarán los archivos cargados
UPLOAD_FOLDER = 'uploads'
os.makedirs(UPLOAD_FOLDER, exist_ok=True)  # Asegúrate de que el directorio exista
app.config['UPLOAD_FOLDER'] = UPLOAD_FOLDER

# Ruta para recibir archivos mediante POST
@app.route('/upload', methods=['POST'])
def upload_file():
    if 'file' not in request.files:
        return jsonify({'error': 'No file part'}), 400

    file = request.files['file']

    if file.filename == '':
        return jsonify({'error': 'No file selected'}), 400

    # Guardar el archivo en el directorio especificado
    file_path = os.path.join(app.config['UPLOAD_FOLDER'], file.filename)
    file.save(file_path)

    return jsonify({
        'status': 'File uploaded successfully',
        'file_path': file_path
    }), 200


# Ruta para servir el archivo index.html
@app.route('/')
def index():
    return send_from_directory(app.config['UPLOAD_FOLDER'], 'index.html')  # Servir el archivo cargado


if __name__ == '__main__':
  app.run(host='192.168.213.128', port=5001, debug=True)
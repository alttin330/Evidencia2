import requests

# Ruta del archivo a enviar
file_path = 'D:/visualStudio/cliente/index.html'  # Cambia por la ruta a tu archivo

# Dirección del servidor Flask
url = 'http://192.168.0.6:5001/upload'  # Cambia por la IP del servidor Flask

# Enviar el archivo como parte de una solicitud POST
with open(file_path, 'rb') as f:
    files = {'file': f}
    response = requests.post(url, files=files)

print(response.status_code, response.json())

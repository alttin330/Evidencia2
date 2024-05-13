import socketio

# Crear una instancia de Socket.IO y conectar al servidor
sio = socketio.Client()
sio.connect('http://localhost:5000')

# Enviar un evento al servidor
sio.emit('my_event', {'data': 'Hello, server'})

# Manejar un evento del servidor
@sio.on('my_response')
def my_response(data):
    print('Mensaje recibido del servidor:', data)

# Mantener la conexión activa
sio.wait()

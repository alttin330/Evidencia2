import socketio

# Crear una instancia de Socket.IO y configurar el servidor
sio = socketio.Server()

# Definir un evento de conexión
@sio.event
def connect(sid, environ):
    print('Cliente conectado', sid)

# Definir un evento personalizado
@sio.event
def my_event(sid, data):
    print('Mensaje recibido del cliente:', data)

# Definir un evento de desconexión
@sio.event
def disconnect(sid):
    print('Cliente desconectado', sid)

# Configurar la aplicación Flask con el servidor Socket.IO
app = socketio.WSGIApp(sio)

if __name__ == '__main__':
    # Iniciar el servidor en el puerto 5000
    import eventlet
    eventlet.wsgi.server(eventlet.listen(('localhost', 5000)), app)

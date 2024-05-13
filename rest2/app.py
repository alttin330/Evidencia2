from flask import Flask, request, jsonify
import MySQLdb

app = Flask(__name__)

# Configura tu conexión a la base de datos
app.config['MYSQL_HOST'] = 'localhost'  # Cambia si tu base de datos está en otro host
app.config['MYSQL_USER'] = 'root'  # Tu usuario de MySQL
app.config['MYSQL_PASSWORD'] = ''  # Tu contraseña de MySQL
app.config['MYSQL_DB'] = 'flask_app'  # El nombre de la base de datos

#------------------------------Create----------------------------------------
@app.route('/empleados', methods=['POST'])
def create_empleado():
    nombre = request.json['nombre']
    edad = request.json['edad']
    departamento = request.json['departamento']

    conn = MySQLdb.connect(
        host=app.config['MYSQL_HOST'],
        user=app.config['MYSQL_USER'],
        passwd=app.config['MYSQL_PASSWORD'],
        db=app.config['MYSQL_DB']
    )
    cursor = conn.cursor()
    cursor.execute("INSERT INTO empleados (nombre, edad, departamento) VALUES (%s, %s, %s)", 
                   (nombre, edad, departamento))
    conn.commit()
    cursor.close()
    conn.close()

    return jsonify({'status': 'Empleado creado exitosamente'}), 201

#--------------------------------Read--------------------------------------
@app.route('/empleados', methods=['GET'])
def read_empleados():
    conn = MySQLdb.connect(
        host=app.config['MYSQL_HOST'],
        user=app.config['MYSQL_USER'],
        passwd=app.config['MYSQL_PASSWORD'],
        db=app.config['MYSQL_DB']
    )
    cursor = conn.cursor()
    cursor.execute("SELECT * FROM empleados")
    empleados = cursor.fetchall()
    cursor.close()
    conn.close()

    return jsonify(empleados)

#---------------------------Update---------------------------------------------
@app.route('/empleados/<int:id>', methods=['PUT'])
def update_empleado(id):
    nombre = request.json['nombre']
    edad = request.json['edad']
    departamento = request.json['departamento']

    conn = MySQLdb.connect(
        host=app.config['MYSQL_HOST'],
        user=app.config['MYSQL_USER'],
        passwd=app.config['MYSQL_PASSWORD'],
        db=app.config['MYSQL_DB']
    )
    cursor = conn.cursor()
    cursor.execute("UPDATE empleados SET nombre = %s, edad = %s, departamento = %s WHERE id = %s", 
                   (nombre, edad, departamento, id))
    conn.commit()
    cursor.close()
    conn.close()

    return jsonify({'status': 'Empleado actualizado exitosamente'})

#--------------------------------------Delete---------------
@app.route('/empleados/<int:id>', methods=['DELETE'])
def delete_empleado(id):
    conn = MySQLdb.connect(
        host=app.config['MYSQL_HOST'],
        user=app.config['MYSQL_USER'],
        passwd=app.config['MYSQL_PASSWORD'],
        db=app.config['MYSQL_DB']
    )
    cursor = conn.cursor()
    cursor.execute("DELETE FROM empleados WHERE id = %s", [id])
    conn.commit()
    cursor.close()
    conn.close()

    return jsonify({'status': 'Empleado eliminado exitosamente'})

#----------------------------------------------------------------
from flask import send_from_directory

@app.route('/')
def index():
    return send_from_directory(r'D:\Python\crud\uploads', 'index.html')

if __name__ == '__main__':
  app.run(host='192.168.213.128', port=5000, debug=True)

import tkinter as tk
from zeep import Client

# Función para sumar números usando el servicio web
def sumar_numeros():
    num1 = int(entrada_num1.get())
    num2 = int(entrada_num2.get())
    resultado = cliente.service.sumar(num1, num2)
    etiqueta_resultado.config(text="Resultado: {}".format(resultado))
    
# Función para restar números usando el servicio web
def restar_numeros():
    num1 = int(entrada_num1.get())
    num2 = int(entrada_num2.get())
    resultado = cliente.service.restar(num1, num2)
    etiqueta_resultado.config(text="Resultado: {}".format(resultado))

# Función para multiplicar números usando el servicio web
def multiplicar_numeros():
    num1 = int(entrada_num1.get())
    num2 = int(entrada_num2.get())
    resultado = cliente.service.multiplicar(num1, num2)
    etiqueta_resultado.config(text="Resultado: {}".format(resultado))

# Función para dividir números usando el servicio web
def dividir_numeros():
    num1 = int(entrada_num1.get())
    num2 = int(entrada_num2.get())
    resultado = cliente.service.dividir(num1, num2)
    etiqueta_resultado.config(text="Resultado: {}".format(resultado))

def obtener_contador():
    contador = cliente.service.getContadorPeticiones()
    etiqueta_contador.config(text="Contador de peticiones: {}".format(contador))

# Crear la ventana principal
ventana = tk.Tk()
ventana.title("Calculadora")

# Crear campo de entrada para el primer número
etiqueta_num1 = tk.Label(ventana, text="Primer número:")
etiqueta_num1.grid(row=0, column=0)
entrada_num1 = tk.Entry(ventana)
entrada_num1.grid(row=0, column=1)

# Crear campo de entrada para el segundo número
etiqueta_num2 = tk.Label(ventana, text="Segundo número:")
etiqueta_num2.grid(row=1, column=0)
entrada_num2 = tk.Entry(ventana)
entrada_num2.grid(row=1, column=1)

# Crear botones para operaciones
boton_restar = tk.Button(ventana, text="-", command=restar_numeros)
boton_restar.grid(row=2, column=0)

boton_sumar = tk.Button(ventana, text="+", command=sumar_numeros)
boton_sumar.grid(row=2, column=1)

boton_multiplicar = tk.Button(ventana, text="*", command=multiplicar_numeros)
boton_multiplicar.grid(row=2, column=2)

boton_dividir = tk.Button(ventana, text="/", command=dividir_numeros)
boton_dividir.grid(row=2, column=3)

# Etiqueta para mostrar el resultado
etiqueta_resultado = tk.Label(ventana, text="")
etiqueta_resultado.grid(row=3, column=0, columnspan=4)

# Botón para obtener el contador de peticiones
boton_contador = tk.Button(ventana, text="Obtener Contador", command=obtener_contador)
boton_contador.grid(row=4, column=0, columnspan=4)

# Etiqueta para mostrar el contador de peticiones
etiqueta_contador = tk.Label(ventana, text="")
etiqueta_contador.grid(row=5, column=0, columnspan=4)

# Crear cliente para el servicio web SOAP
cliente = Client('http://192.168.227.83:8080/WSSoap/CalculadoraWSService?WSDL')

# Ejecutar el bucle principal de la ventana
ventana.mainloop()

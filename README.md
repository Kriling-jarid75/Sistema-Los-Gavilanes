<div align="center">

# 🍗 Sistema Los Gavilanes

**Sistema de registro de clientes y órdenes para agilizar la atención de un negocio de comida**

![Estado](https://img.shields.io/badge/status-en%20producci%C3%B3n-brightgreen)
![Tipo](https://img.shields.io/badge/tipo-sistema%20de%20gesti%C3%B3n-blue)
![Tickets](https://img.shields.io/badge/impresi%C3%B3n-tickets-orange)

</div>

---

## 📌 Descripción

Software desarrollado para **registrar clientes y órdenes** en un negocio de comida que, antes del sistema, anotaba los pedidos en **papeletas**. Ese proceso manual generaba problemas constantes, sobre todo con las **direcciones de los clientes**, y alargaba los tiempos de atención.

Con el sistema, toda la información queda centralizada, ordenada y disponible al instante, lo que simplifica los procesos del día a día y **optimiza el tiempo** para preparar y despachar cada orden.

## ✨ Funcionalidades

- 👤 **Registro de clientes** — datos de contacto y direcciones guardadas para no volver a capturarlas.
- 🧾 **Registro de órdenes** — pedidos asociados a cada cliente, sin papeletas de por medio.
- 📍 **Control de direcciones** — se acabó el buscar o descifrar domicilios anotados a mano.
- 🖨️ **Impresión de tickets** — comprobantes de cada orden listos para cocina y reparto.
- ⚡ **Atención más rápida** — menos tiempo capturando, más tiempo atendiendo.

## 🔄 Antes vs. Después

| | Antes | Con el sistema |
|---|---|---|
| Registro de pedidos | Papeletas | Captura digital |
| Direcciones | Difíciles de ubicar | Guardadas por cliente |
| Tiempo por orden | Alto | Optimizado |
| Comprobante | Manual | Ticket impreso |

## 🛠️ Stack técnico

| Capa | Tecnología |
|------|------------|
| Aplicación / Servidor | _Completa aquí_ |
| Base de datos | _Completa aquí_ |
| Impresión de tickets | Driver de impresora incluido en el repositorio |

## 📁 Estructura del proyecto

```
Sistema-Los-Gavilanes/
├── Base de datos/                      # Scripts y respaldo de la base de datos
├── DRIVER-DE-IMPRESORA/                # Driver para la impresión de tickets
├── Librerias/                          # Dependencias necesarias del proyecto
├── proyectoGavilanesServidorOriginal/  # Código fuente del sistema
├── tickets/                            # Formatos / ejemplos de tickets
└── README.md
```

## 🚀 Instalación

1. **Clona el repositorio**
   ```bash
   git clone https://github.com/Kriling-jarid75/Sistema-Los-Gavilanes.git
   cd Sistema-Los-Gavilanes
   ```
2. **Restaura la base de datos** con los archivos de la carpeta `Base de datos/`.
3. **Instala el driver de la impresora** desde `DRIVER-DE-IMPRESORA/`.
4. **Agrega las librerías** de `Librerias/` al proyecto.
5. **Ejecuta** el proyecto desde `proyectoGavilanesServidorOriginal/`.

## 🚀 Impacto

- Eliminó el uso de papeletas y los errores al anotar direcciones.
- Redujo el tiempo de captura y atención de cada orden.
- Dio al negocio un registro confiable de clientes y pedidos.

## 👨‍💻 Autor

Desarrollado por [**Kriling-jarid75**](https://github.com/Kriling-jarid75)

---

<div align="center">⭐ Si te sirvió este proyecto, déjale una estrella ⭐</div>

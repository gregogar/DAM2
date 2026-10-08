from odoo import models, fields

class Equipo (models.Model):
    _name = "bytemadrid.equipo"
    _description = "Equipo Informático"
    
    
    name = fields.Char(
        string="nombre del equipo",
        required=True
    )

    fabricante = fields.Char(
        string="nombre del fabricante",
        required=True
    )

    modelo = fields.Char(
        string="nombre del modelo"
    )

    precio = fields.Float(
        string="precio"
    )

    estado = fields.Boolean(
        string="activo",
        default=True
    )

    numero_serie = fields.Char(
        string="Numero de serie"
    )
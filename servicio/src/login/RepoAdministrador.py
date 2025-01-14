from flask_app.app import db
from src.login.Administrador import Administrador


class RepoAdministrador:

    def __init__(self):
        self.cur = db.get_cursor()

    def existe(self, admin: Administrador) -> bool:
        self.cur.execute(f'''select exists(select * from administrador
                            where ced_adm = '{admin.cedula}'
                            and pas_adm = '{admin.password}') as existe''')
        return self.cur.fetchone()['existe']

    def get_rol(self, admin: Administrador) -> str:
        self.cur.execute(f'''select rol_adm as rol_admin from administrador where ced_adm = {admin.cedula}''')
        return self.cur.fetchone()['rol_admin']

    def buscar(self, cedula: str) -> Administrador:
        self.cur.execute(f'''select ced_adm as cedula_admin, 
                        nom_adm as nombre_admin, 
                        ape_adm as apellido_admin
                        from administrador 
                        where ced_adm = {cedula};''')
        data: dict = self.cur.fetchone()
        return Administrador(**data)

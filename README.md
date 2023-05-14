# FLAPPY_BIRD

## EXPLICACION
trabajaremos en intelliji por lo cual tendran que seguir los siguientes pasos
1. si lees esto significa que ya acpetaste la invitacion por lo que habra una seccion dentro de github web que dice code
   dale click a ese boton y copia la url que aparece. Aqui te lo proporciono
```bash
https://github.com/axelleonardo-1/FLAPPY_AX_AR_YA.git
```
2. una vez que tengas el url dirigite a explorador de archivos y crea una carpeta vacia donde ingresaras el proyecto
   una vez que estes ahi usa el cmd de esa carpeta y usa el siguiente comando "git clone <url>"
```bash
git clone https://github.com/axelleonardo-1/FLAPPY_AX_AR_YA.git
```
3. se deberia de actualizar todo y estariamos listo para trabajar

## INTELLIJ
una vez teniendo el repositorio creado intellij proporciona una opcion que dice GIT por lo que habra disitntas opciones basicas
como pull, push, merge, branch, etc. En caso de no haber una opcion dentro de intellij prodremos ejecutarla en la terminal que nos
proporciona la app

## COMANDOS BASICOS

Realizar cambios
Una vez que tienes un repositorio local, puedes empezar a hacer cambios en los archivos del proyecto. Usa el comando git status para ver los cambios pendientes.
```bash
git status
```

Para agregar los cambios a un nuevo commit, usa el comando git add. Puedes agregar archivos individuales o todos los archivos modificados.
```bash
git add archivo-modificado.txt
```

Luego, crea un nuevo commit con el comando git commit. Asegúrate de incluir un mensaje descriptivo de los cambios realizados.
```bash
git commit -m "Mensaje de descripción de los cambios realizados"
```


Subir cambios
Para subir los cambios realizados en tu repositorio local a GitHub, usa el comando git push. Necesitas indicar el nombre del repositorio remoto y la rama que quieres subir.
```bash
git push nombre-del-repositorio-remoto nombre-de-la-rama
```


Descargar cambios
Para descargar los cambios realizados por otros colaboradores en el repositorio remoto, usa el comando git pull.
```bash
git pull nombre-del-repositorio-remoto nombre-de-la-rama
```

## RAMAS (IMPORTANTE)
las ramas son de semejantes importancia aqui ya que es el espacio personal de cada uno donde podremos ver que ha hecho cada persona y los cambios que ha realizado
cada persona tendra su rama donde tendra sus propias clases. Es recomendable ejecutarlos desde intellij

Usa el comando git branch para ver las ramas actuales.
```bash
git branch
```

Para crear una nueva rama, usa el comando git branch seguido del nombre de la nueva rama.
```bash
git branch nombre-de-la-nueva-rama
```

usa el comando git checkout para cambiar a la nueva rama o una rama existente.
```bash
git checkout nombre-de-la-nueva-rama
```



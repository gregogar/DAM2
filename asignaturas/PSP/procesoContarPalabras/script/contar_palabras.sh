#!/usr/bin/env bash

# 1. Comprobar que se han pasado los 2 argumentos
if [ "$#" -lt 2 ]; then
    echo "Error. Uso correcto: $0 <archivo_de_texto> <palabra>"
    exit 1
fi

ARCHIVO="$1"
PALABRA="$2"

# 2. Comprobar si el archivo de texto realmente existe
if [ ! -f "$ARCHIVO" ]; then
    echo "Error: El archivo \"$ARCHIVO\" no existe."
    exit 1
fi

# 3. Contar apariciones exactas ignorando mayúsculas/minúsculas
CANTIDAD=$(grep -oiw -- "$PALABRA" "$ARCHIVO" | wc -l)

# 4. Mostrar el resultado
echo "$CANTIDAD"
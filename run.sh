#!/bin/bash

# Script para ejecutar el proyecto Java compilado
# Ejecuta la clase principal desde el directorio build

# Colores para output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

echo -e "${YELLOW}=== Ejecutando proyecto Java ===${NC}"

# Verificar si existe el directorio build
if [ ! -d "build" ]; then
    echo -e "${RED}Error: No se encontró el directorio 'build'${NC}"
    echo -e "${YELLOW}Ejecuta primero ./compile.sh para compilar el proyecto${NC}"
    exit 1
fi

# Verificar si hay archivos .class en build
CLASS_FILES=$(find build -name "*.class" 2>/dev/null)
if [ -z "$CLASS_FILES" ]; then
    echo -e "${RED}Error: No se encontraron archivos .class en el directorio build${NC}"
    echo -e "${YELLOW}Ejecuta primero ./compile.sh para compilar el proyecto${NC}"
    exit 1
fi

# Buscar el único archivo .class que contenga método main
MAIN_CLASS="presenter.App"

# Ejecutar la clase principal
if [ $# -gt 0 ]; then
    echo -e "${GREEN}Ejecutando: java -cp build ${MAIN_CLASS} $*${NC}"
else
    echo -e "${GREEN}Ejecutando: java -cp build ${MAIN_CLASS}${NC}"
fi
echo -e "${YELLOW}=========================${NC}"

java -cp build "$MAIN_CLASS" "$@"

# Capturar código de salida
EXIT_CODE=$?

echo -e "${YELLOW}=========================${NC}"
if [ $EXIT_CODE -eq 0 ]; then
    echo -e "${GREEN}✓ Programa ejecutado correctamente${NC}"
else
    echo -e "${RED}✗ El programa terminó con código de error: $EXIT_CODE${NC}"
fi

exit $EXIT_CODE
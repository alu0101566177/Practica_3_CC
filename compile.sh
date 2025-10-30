#!/bin/bash

# Script para compilar el proyecto Java
# Compila todos los archivos .java de src/ y genera los .class en build/

# Colores para output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

echo -e "${YELLOW}=== Compilando proyecto Java ===${NC}"

# Verificar si existe el directorio src
if [ ! -d "src" ]; then
    echo -e "${RED}Error: No se encontró el directorio 'src'${NC}"
    exit 1
fi

# Crear directorio build si no existe
if [ ! -d "build" ]; then
    echo -e "${YELLOW}Creando directorio build...${NC}"
    mkdir -p build
fi

# Limpiar compilaciones anteriores
echo -e "${YELLOW}Limpiando compilaciones anteriores...${NC}"
rm -rf build/*

# Buscar archivos .java en todas las subcarpetas de src
JAVA_FILES=$(find src -name "*.java" 2>/dev/null)

if [ -z "$JAVA_FILES" ]; then
    echo -e "${RED}Error: No se encontraron archivos .java en el directorio src${NC}"
    exit 1
fi

echo -e "${YELLOW}Archivos Java encontrados:${NC}"
echo "$JAVA_FILES"

# Compilar archivos Java
echo -e "${YELLOW}Compilando archivos Java...${NC}"
javac -cp src -d build $JAVA_FILES

# Verificar si la compilación fue exitosa
if [ $? -eq 0 ]; then
    echo -e "${GREEN}✓ Compilación exitosa${NC}"
    echo -e "${GREEN}Los archivos .class se han generado en el directorio 'build'${NC}"
    
    # Mostrar estructura de build
    echo -e "${YELLOW}Estructura del directorio build:${NC}"
    find build -name "*.class" 2>/dev/null | sort
else
    echo -e "${RED}✗ Error durante la compilación${NC}"
    exit 1
fi
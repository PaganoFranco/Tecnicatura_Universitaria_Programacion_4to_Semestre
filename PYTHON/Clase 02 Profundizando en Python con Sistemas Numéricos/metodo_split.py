
# help(str.split)

cursos = 'Java JavaScript Node Python Diseno'
lista_cursos = cursos.split()
print(f'Lista de cursos: {lista_cursos}')
print(type(lista_cursos))

cursos_separados_comas = 'Java,Python,Node,JavaScript,Spring'
lista_cursos = cursos_separados_comas.split(',',2)
print(f'Lista de cursos: {lista_cursos}')
print(len(lista_cursos))
# RPN Stacker

O interpretador funciona em 3 etapas:
- Leitura dos tokens
   Ele lê um arquivo linha por linha para atribuir seus conteúdos a tokens.
- Detecção de variáveis
   Após gerar os tokens, ele os avalia para detectar que variáveis foram declaradas no arquivo.
- Cálculos
   Tendo gerado os tokens e encontrado as variáveis, ele pode examinar os cálculos no resto do arquivo para encontrar o resultado

   
## Como Usar
O Interpretador foi configurado no Eclipse para ler o arquivo [example.stk](example.stk) quando executado. Mas você pode alterá-lo ou criar um novo arquivo seguindo essas regras:
1. Escreva um operador, variável, ou número por linha. O interpretador lê uma linha de cada vez.
2. Declare todas as variáveis primeiro e todos cálculos depois.

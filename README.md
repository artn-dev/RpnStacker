# RPN Stacker

O interpretador funciona em 3 etapas:
- Leitura dos tokens
   Ele l� um arquivo linha por linha para atribuir seus conte�dos a tokens.
- Detec��o de vari�veis
   Ap�s gerar os tokens, ele os avalia para detectar que vari�veis foram declaradas no arquivo.
- C�lculos
   Tendo gerado os tokens e encontrado as vari�veis, ele pode examinar os c�lculos no resto do arquivo para encontrar o resultado

   
## Como Usar
O Interpretador foi configurado no Eclipse para ler o arquivo [example.stk](example.stk) quando executado. Mas voc� pode alter�-lo ou criar um novo arquivo seguindo essas regras:
1. Escreva um operador, vari�vel, ou n�mero por linha. O interpretador l� uma linha de cada vez.
2. Declare todas as vari�veis primeiro e todos c�lculos depois.

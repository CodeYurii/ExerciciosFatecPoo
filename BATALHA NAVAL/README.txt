Instruções
Implemente uma solução orientada a objetos (não precisa de entrada de dados do usuário via teclado, pois não estudamos isso ainda) que permita a criação de um jogo de batalha naval. 
Neste jogo, o tabuleiro tem dois lados. 
O lado esquerdo e direito têm matrizes de tamanhos iguais cada: 7 linhas x 10 colunas. 
O jogo funciona por turnos: uma jogada do jogador 1, outra do jogador 2 e assim sucessivamente. 
O jogador 1 deve posicionar seus navios em algumas células da sua matriz. 
O mesmo para o jogador 2. 
Quando o jogador 1 joga, ele deve informar uma linha/coluna da matriz do jogador 2 e, se ele acertar uma célula onde o jogador 2 colocou um navio, ele ganha 1 ponto. 
Ganha quem encontrar todas as células do navio do outro primeiro. 
Você pode definir no próprio código do programa principal os locais onde ficarão os navios do jogador 1 e jogador 2 e testar algumas jogadas para ver se o jogo funciona.

Para usar matrizes em Java, utilize a seguinte estrutura:

// Cria uma matriz 7x10 booleana:
boolean[][] matriz = new boolean[7][10];

// Altera o valor da linha 0, coluna 0 para true (o valor padrão é false):
matriz[0][0] = true;
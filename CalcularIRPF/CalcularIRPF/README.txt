Instruções
GRANDE DESAFIO DA NOITE
FAZER UM PROGRAMA QUE CALCULE O IMPOSTO DE RENDA A SER PAGO, BASEANDO-SE NAS TABELAS DO IRPF 2024
FAIXA 1 Menos de R$ 2.259,21 : isento
FAIXA 2 De R$ 2.259,21 até R$ 2.826,65: alíquota 7,5%
FAIXA 3 De R$ 2.826,66 até R$ 3.751,05: alíquota 15%
FAIXA 4 De R$ 3.751,06 até R$ 4.664,68: alíquota 22,5%
FAIXA 5 Acima de R$ 4.664,68: alíquota 27,5%

O Calculo é realizado conforme as seguintes expressões
FAIXA 2
Imposto a pagar = Se o rendimento for <= 2.865,65, então (Rendimento - Piso da faixa )*7,5%

FAIXA 3
Se o Rendimento entre R$ 2.826,66 E   R$ 3.751,05:
Imposto a pagar = ((Rendimento - Teto da faixa2)*7,5%)+ ( (Rendimento - Piso da faixa3 )*15% ))

FAIXA 4
Se o Rendimento entre R$ 3.751,06 E R$ 4.664,68:
Imposto a pagar = ((Rendimento - Teto da faixa3)*15%)+
((Rendimento - Teto da faixa2)*7,5%)+ (Rendimento - Piso da faixa4 )*22% ))
FAIXA 5
Se o Rendimento MAIOR que  R$ 4.664,68
Imposto a pagar = ((Rendimento - Teto da faixa4)*22%)+
+((Rendimento - Teto da faixa3)*15%)+ ((Rendimento - Teto da faixa2)*7,5%)+  (Rendimento - Piso da faixa5 )*27,5% ))

A sáida do programa deve imprimir o nome da pessoa. Qual Aliquota ela irá pagar e o valor.
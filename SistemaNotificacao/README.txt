Instruções
Enunciado do Problema: Sistema de Notificação

Contexto:
Uma aplicação precisa enviar diferentes tipos de notificações (com mensagens) para seus usuários. 
Essas notificações podem ser enviadas via e-mail, SMS, ou através de uma mensagem em um aplicativo de mensagens. 
Cada tipo de notificação tem sua própria maneira de ser enviada, mas todas compartilham a ideia central de entregar uma mensagem ao destinatário.

Objetivo:
Assuma que para cada usuário de uma aplicação, existem diferentes tipos de preferências de notificações cadastradas (SMS, e-mail ou aplicativo de mensagem). 
Por exemplo, Joãozinho deseja receber apenas notificações por SMS. Mariazinha prefere SMS e e-mail etc.
Para simplificar, assuma que enviar uma notificação por cada um dos meios só envolve imprimir na tela uma mensagem (como: Enviando notificação via SMS), 
mas num sistema real, cada tipo de notificação terá sua própria lógica de envio. 
Crie um sistema que permite que cada usuário tenha relação com diferentes tipos de notificação (suas preferências). 
Ainda, o sistema deve ter um notificador que, ao receber um usuário, envia as notificações para o usuário (na nossa simulação, 
ele deve apenas imprimir uma mensagem na tela para cada tipo de notificação).
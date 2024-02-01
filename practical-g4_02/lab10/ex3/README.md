
# Problem

Supondo que se está a desenvolver um sistema de chat em tempo real, onde vários users podem comunicar entre si. Cada utilizador pode enviar mensagens para outros em específico ou para grupos. No entanto, no entando o código para isso seria demasiado complexo e difícil de manter, uma vez que cada user precisa conhecer e interagir diretamente com os outros.


# Solution

A solução proposta é aplicar o padrão Mediator, onde o mediador será centralizado e irá gerenciar as comunicações entre os varios utilizadores, assim reduz-se o acoplamento, simplificando o código, pois assim os utilizadores não precisam de conhecer todos os outros com quem estão a falar.


# References

Material da disciplina

https://refactoring.guru/design-patterns/mediator

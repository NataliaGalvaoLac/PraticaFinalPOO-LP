RELATÓRIO FINAL – MINI SIMULADOR DE REDE SOCIAL

Introdução
O objetivo deste projeto é criar um Mini Simulador de Rede Social em Java, com funcionalidades de cadastro de usuários, gerenciamento de amigos e envio de mensagens. A solução proposta utiliza uma estrutura de dados que permite um número indefinido de entradas, por meio de classes abstratas, herança, interfaces e polimorfismo. Além disso, será implementada uma interface gráfica utilizando bibliotecas gráficas em Java.

Estrutura de Dados
A estrutura de dados utilizada neste projeto é baseada em classes e objetos em Java. A classe abstrata "Usuario" representa um usuário genérico e possui atributos como nome, email, senha, sexo e nacionalidade. A classe "UsuarioComum" herda da classe abstrata "Usuario" e implementa os métodos específicos, como enviar mensagem, adicionar amigo, remover amigo e listar amigos. Essa estrutura permite a criação de um número indefinido de usuários e o gerenciamento de suas informações.

Desenvolvimento
O código utiliza conceitos como classe abstrata, herança, interface e polimorfismo para implementar a funcionalidade da rede social.
A classe abstrata "Usuario" fornece os atributos básicos comuns a todos os usuários da rede social e é estendida pela classe "UsuarioRedeSocial", que adiciona os atributos específicos da rede social, como lista de amigos e mensagens. A classe "UsuarioRedeSocial" também implementa a interface "Amigo", que define os métodos relacionados a amizades.
Os principais métodos implementados são:
•	adicionarAmigo(Usuario amigo): adiciona um usuário à lista de amigos de um usuário.
•	removerAmigo(Usuario amigo): remove um usuário da lista de amigos de um usuário.
•	listarAmigos(): lista os amigos de um usuário.
•	enviarMensagem(Usuario amigo, String mensagem): envia uma mensagem para um amigo específico.
•	listarMensagens(Usuario amigo): lista as mensagens trocadas com um amigo específico.
Esses métodos permitem que os usuários adicionem amigos, removam amigos, vejam a lista de amigos, enviem mensagens e visualizem suas conversas.

Padrões de Projeto utilizados
Neste projeto, foram utilizados conceitos de orientação a objetos e princípios de design de software, mas não foram aplicados padrões de projeto específicos.



Interface Gráfica
O código utiliza a biblioteca gráfica Swing para criar uma interface gráfica básica. A classe "SistemaRedeSocial" contém o método menuPrincipal(), que cria uma janela JFrame com dois botões: "Cadastrar Usuário" e "Realizar Login". Quandoo usuário clica em um dos botões, a ação correspondente é executada, chamando os métodos cadastrarUsuario() ou realizarLogin() respectivamente.
A interface gráfica fornece uma maneira mais amigável e interativa para interagir com o sistema da rede social, em vez de simplesmente usar a linha de comando.

Conclusão
A implementação do Mini Simulador de Rede Social em Java utilizando classes abstratas, herança, interfaces e polimorfismo permite a criação e gerenciamento de usuários, amigos e mensagens de forma eficiente e flexível. A utilização de uma estrutura de dados adequada e a integração com um banco de dados permitem armazenar e recuperar as informações dos usuários de forma persistente. 

Durante o desenvolvimento, foram encontradas algumas dificuldades, como a correta implementação da lógica de autenticação dos usuários, a sincronização entre a interface gráfica e a lógica de negócio. 

Não foi possível realizar a integração com o banco de dados.

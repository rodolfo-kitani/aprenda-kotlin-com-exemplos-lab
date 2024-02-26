enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario (var nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario);
        println("usuário ${usuario.nome} matriculado")
    }

    fun listarUsuariosMatriculados() {
        println("A Formação possui ${inscritos.size} alunos inscritos")
        for (usuario in inscritos) println("- ${usuario.nome}")
    }

    fun duracaoTotal() {
        var total: Int = 0;
        for (conteudo in conteudos) {
            total += conteudo.duracao
        }
        println("A Formação tem $total min de duração")
    }
}

fun main() {
    // TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    // Adicionei nome aos usuarios para retornar o nome do usuario matriculado e um metodo para listar os inscritos.
    // TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
    val usuario1 = Usuario("Rodolfo");
    val usuario2 = Usuario("Carol");
    val usuario3 = Usuario("João");

    val curso1 = ConteudoEducacional("Aula Banco de Dados");
    val curso2 = ConteudoEducacional(nome = "Lógica de Prog.", duracao = 120)

    val listaDeCursos = mutableListOf(curso1, curso2)

    val formacao1 = Formacao("Formação Bacana", Nivel.INTERMEDIARIO, listaDeCursos)
    formacao1.duracaoTotal()
    formacao1.listarUsuariosMatriculados()

    formacao1.matricular(usuario1)
    formacao1.matricular(usuario2)
    formacao1.matricular(usuario3)

    formacao1.listarUsuariosMatriculados()
}
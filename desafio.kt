// Enum para representar os níveis de dificuldade
enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

// Classe para representar um usuário
data class Usuario(val nome: String)

// Classe abstrata para representar conteúdos educacionais
abstract class ConteudoEducacional(val nome: String, val duracao: Int = 60)

// Classe que herda de ConteudoEducacional para representar um curso
class Curso(nome: String, duracao: Int = 60, val nivel: Nivel) : ConteudoEducacional(nome, duracao)

// Classe para representar uma formação
class Formacao(val nome: String) {

    val conteudos = mutableListOf<ConteudoEducacional>()
    val inscritos = mutableListOf<Usuario>()

    // Função para matricular um usuário na formação
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("$usuario matriculado na formação $nome")
    }

    // Função para adicionar um conteúdo à formação
    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
        println("Conteúdo '${conteudo.nome}' adicionado à formação $nome")
    }

    // Função para listar os conteúdos disponíveis na formação
    fun listarConteudos() {
        println("Conteúdos disponíveis na formação $nome:")
        conteudos.forEach { println("- ${it.nome}") }
    }
}

fun main() {
    // Criando alguns objetos para testar o código
    val usuario1 = Usuario("Lucas")
    val usuario2 = Usuario("Estefany")

    val cursoKotlin = Curso("Kotlin Básico", 30, Nivel.BASICO)
    val cursoJava = Curso("Java Avançado", 45, Nivel.INTERMEDIARIO)

    val formacaoTI = Formacao("Formação em TI")
    formacaoTI.adicionarConteudo(cursoKotlin)
    formacaoTI.adicionarConteudo(cursoJava)

    formacaoTI.listarConteudos()
    formacaoTI.matricular(usuario1)
    formacaoTI.matricular(usuario2)
}

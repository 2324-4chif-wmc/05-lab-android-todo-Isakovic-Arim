package at.htl.todo.ui.layout

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import at.htl.todo.model.Model
import at.htl.todo.model.ModelStore
import at.htl.todo.model.Todo
import at.htl.todo.model.TodoService

@Composable
fun Details(model: Model, toDoService: TodoService?, store: ModelStore?) {
    val todos = model.todos

    LazyColumn (modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        items(todos.size) {
            index -> TodoCard(todo = todos[index])
        }
    }
}

@Composable
fun TodoCard(todo: Todo) {
    Card(
        onClick = {todo.completed = !todo.completed},
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier
            .size(width = 240.dp, height = 100.dp)

    ) {
        Text(
            text = todo.title,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center
        )
        Text(
            text = "completed: " + todo.completed,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center
        )
    }
}
package ru.yandex.architectureproject.domain

import kotlinx.coroutines.delay
import ru.yandex.architectureproject.data.repository.TaskRepository

class CompleteTaskUseCase(
    private val repository: TaskRepository,
) {
    suspend operator fun invoke(taskId: Int) {
        repository.completeTask(taskId)
        delay(DELAY_TIMES)
        repository.deleteTask(taskId)
    }

    private companion object {
        private const val DELAY_TIMES = 10_000L
    }
}

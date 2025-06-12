package lsp.project.training.ticketing

import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import lsp.project.training.ticketing.controller.TicketCounter

fun main() = runBlocking {
  val ticketCounter = TicketCounter()

  val t1 = launch {
    ticketBookingCoroutine(ticketCounter, "Farhan", 3)
  }

  val t2 = launch {
    ticketBookingCoroutine(ticketCounter, "Yudhistira", 2)
  }
  val dtt1 = launch {
    droppedTicketCoroutine(ticketCounter, 2)
  }

  joinAll(t1, t2, dtt1)
}

suspend fun ticketBookingCoroutine(tc: TicketCounter, name: String, seats: Int) {
  tc.bookTicket(name, seats)
}

suspend fun droppedTicketCoroutine(tc: TicketCounter, seats: Int) {
  tc.dropTicket(seats)
}
package lsp.project.training.ticketing.controller

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class TicketCounter {
  private var availableSeats = 3
  private val mutex = Mutex()

  suspend fun bookTicket(name: String, numberOfSeats: Int) {
    mutex.withLock {
      if (numberOfSeats in 1..availableSeats) {
        println("Available Ticket = $availableSeats")
        println("Hi, $name: seat: $numberOfSeats booked successfully...")
        availableSeats -= numberOfSeats
      } else {
        println("Sorry, $name: Seats not available.")
      }
    }
  }

  suspend fun dropTicket(droppedTicket: Int) {
    mutex.withLock {
      if (availableSeats == 0) {
        availableSeats += droppedTicket
        println("Available Ticket = $availableSeats")
        println("$availableSeats ticket(s) have been added")
      }
    }
  }
}
package com.example.a200429757_midterm;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;



    public class game {
        private String GameId;
        private String choice;
        private String Winner;

        public game(){

        }

        public game(String gameId, String choice, String winner) {
            this.GameId= gameId;
            this.choice = choice;
            this.Winner = winner;
        }

        public String getGameId() {
            return choice;
        }

        public String getChoice() {
            return choice;
        }

        public String getWinner() {
            return Winner;
        }
    }


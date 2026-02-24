package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    
    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed, XPressed, QPressed, shotKeyPressed;
    
    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {
     
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        
        //TITLE STATE
        if (gp.gameState == gp.titleState) {
            if (gp.ui.titleScreenState == 0) {
                if (code == KeyEvent.VK_W) {
                    gp.ui.commandNum--;
                    gp.playSE(11);
                    if (gp.ui.commandNum < 0) {
                        gp.ui.commandNum = 0;
                    }
                }
                if (code == KeyEvent.VK_S) {
                    gp.ui.commandNum++;
                    gp.playSE(11);
                    if (gp.ui.commandNum > 3) {
                        gp.ui.commandNum = 3;
                    }
                }
                
                if (code == KeyEvent.VK_X) {
                    switch (gp.ui.commandNum) {
                        case 0:
                            gp.ui.titleScreenState = 1;
                            break;
                        case 3:
                            System.exit(0);
                            break;
                    }
                }
            } else if (gp.ui.titleScreenState == 1) {
                if (code == KeyEvent.VK_W || code == KeyEvent.VK_S) {
                    gp.ui.commandNum += (code == KeyEvent.VK_W) ? -1 : 1;
                    gp.playSE(11);
                    gp.ui.commandNum = Math.min(Math.max(gp.ui.commandNum, 0), 4);
                }
                if (code == KeyEvent.VK_X) {
                    if (gp.ui.commandNum == 4) {
                        gp.ui.titleScreenState = 0;
                    } else {
                        gp.gameState = gp.playState;
                    }
                }
            }
        }
        
        //PLAY STATE
        else if (gp.gameState == gp.playState) {
            switch (code) {
                case KeyEvent.VK_W:
                    upPressed = true;
                    break;
                case KeyEvent.VK_S:
                    downPressed = true;
                    break;
                case KeyEvent.VK_A:
                    leftPressed = true;
                    break;
                case KeyEvent.VK_D:
                    rightPressed = true;
                    break;
                case KeyEvent.VK_F:
                    shotKeyPressed = true;
                    break;
                case KeyEvent.VK_C:
                    gp.gameState = gp.characterState;
                    break;
                case KeyEvent.VK_X:
                    XPressed = true;
                    break;
                case KeyEvent.VK_Q:
                    QPressed = true;
                    break;
                case KeyEvent.VK_ESCAPE:
                    gp.gameState = gp.optionsState;
                    break;
                case KeyEvent.VK_P:
                    gp.gameState = gp.pauseState;
                    gp.music.pause();
                    break;
            }
        }
        
        //CHARACTER STATE
        else if (gp.gameState == gp.characterState) {
            if (code == KeyEvent.VK_C) {
                gp.gameState = gp.playState;
            }
            if (code == KeyEvent.VK_X) {
            	gp.hypu.selectItem();
            }
            playerInventory(code);
        }
        
        //OPTIONS STATE
        else if (gp.gameState == gp.optionsState) {
            optionsState(code);
        }
        
        //GAME OVER STATE
        else if (gp.gameState == gp.gameOverState) {
            gameOverState(code);
        }
        
      //TRADE STATE
        else if (gp.gameState == gp.tradeState) {
            tradeState(code);
        }
        
        //PAUSE STATE
        else if (gp.gameState == gp.pauseState && code == KeyEvent.VK_P) {
            gp.gameState = gp.playState;
            gp.music.resume();
        }

        //DIALOGUE STATE
        else if (gp.gameState == gp.dialogueState && code == KeyEvent.VK_X) {
            gp.gameState = gp.playState;
        }
    }

    public void optionsState(int code) {
    	
    	if(code == KeyEvent.VK_ESCAPE) {
    		gp.gameState = gp.playState;
    	}
    	
    	if (code == KeyEvent.VK_X) {
    		XPressed = true;
    	} 
    	
    	int maxCommandNum = 0;   	
    	switch(gp.ui.subState) {    	
    	case 0: maxCommandNum = 5; break;  	
    	case 3: maxCommandNum = 1; break; 
    	}
    	
    	if (code == KeyEvent.VK_W) {
    	    gp.ui.commandNum--;
    	    gp.playSE(11);
    	    if (gp.ui.commandNum < 0) {
    	        gp.ui.commandNum = 0; 
    	    }
    	}

    	if (code == KeyEvent.VK_S) {
    	    gp.ui.commandNum++;
    	    gp.playSE(11);
    	    if (gp.ui.commandNum > maxCommandNum) {
    	        gp.ui.commandNum = maxCommandNum; 
    	    }
    	}

    	
    	if (code == KeyEvent.VK_A) {
    		
    		if (gp.ui.subState == 0) {
    			if (gp.ui.commandNum == 1 && gp.music.volumeScale > 0) {
    				gp.music.volumeScale--;
    				gp.music.checkVolume();
    				gp.playSE(11);
    			}
    			if (gp.ui.commandNum == 2 && gp.se.volumeScale > 0) {
    				gp.se.volumeScale--;
    				gp.playSE(11);
    			}
    		}   		
    	}
    	
    	if (code == KeyEvent.VK_D) {
    		if (gp.ui.subState == 0) {
    			if (gp.ui.commandNum == 1 && gp.music.volumeScale < 5) {
    				gp.music.volumeScale++;
    				gp.music.checkVolume();
    				gp.playSE(11);
    			} 			
    			if (gp.ui.commandNum == 2 && gp.se.volumeScale < 5) {
    				gp.se.volumeScale++;
    				gp.playSE(11);
    			}
    		}  		
    	}
    }
    
    public void gameOverState(int code) {
    	
    	if (code == KeyEvent.VK_W) {
    		gp.ui.commandNum--;
    		if (gp.ui.commandNum < 0) {
    			gp.ui.commandNum = 0;
    		}
    		gp.playSE(11);	
    	}
    	
    	if (code == KeyEvent.VK_S) {
    		gp.ui.commandNum++;
    		if (gp.ui.commandNum > 1) {
    			gp.ui.commandNum = 1;
    		}
    		gp.playSE(11);	
    	}
    	
    	if (code == KeyEvent.VK_X) {	
    		if (gp.ui.commandNum == 0) {
    			gp.gameState = gp.playState;
    			gp.retry();
    			gp.playMusic(0);
    		}
    		else if (gp.ui.commandNum == 1) {
    			gp.gameState = gp.titleState;
    			gp.ui.titleScreenState = 0;
    			gp.ui.commandNum = 0;
    			gp.restart();
    		}
    	}
    }
    
    public void tradeState(int code) {
    	
    	if (code == KeyEvent.VK_X) {
    		XPressed = true;
    	}
    	
    	if (gp.ui.subState == 0) {
    		if (code == KeyEvent.VK_W) {
    			gp.ui.commandNum--;
    			if (gp.ui.commandNum < 0) {
    				gp.ui.commandNum = 0;
    			}
    			gp.playSE(11);
    		}
    
        	if (code == KeyEvent.VK_S) {
        		gp.ui.commandNum++;
        		if (gp.ui.commandNum > 2) {
        			gp.ui.commandNum = 2;
        		}
        		gp.playSE(11);
        	}		
    	}
    	
    	if (gp.ui.subState == 1) {
    		npcInventory(code);
    		if (code == KeyEvent.VK_ESCAPE) {
    			gp.ui.subState = 0;
    		}
    	}
    	
    	if (gp.ui.subState == 2) {
    		playerInventory(code);
    		if (code == KeyEvent.VK_ESCAPE) {
    			gp.ui.subState = 0;
    		}
    	}
    }
    
    public void playerInventory(int code) {
    	
    	if (code == KeyEvent.VK_W) {
        	if (gp.ui.playerSlotRow != 0) {
        		gp.ui.playerSlotRow--;
            	gp.playSE(11);
        	}
        }
        if (code == KeyEvent.VK_A) {
        	if (gp.ui.playerSlotCol != 0) {
            	gp.ui.playerSlotCol--;
            	gp.playSE(11);
        	}
        }
        if (code == KeyEvent.VK_S) {
        	if (gp.ui.playerSlotRow != 3) {
        		gp.ui.playerSlotRow++;
            	gp.playSE(11);
        	}
        }
        if (code == KeyEvent.VK_D) {
        	if (gp.ui.playerSlotCol != 4) {
            	gp.ui.playerSlotCol++;
            	gp.playSE(11);
        	}
        }
    }
    
    public void npcInventory(int code) {
    	
    	if (code == KeyEvent.VK_W) {
        	if (gp.ui.npcSlotRow != 0) {
        		gp.ui.npcSlotRow--;
            	gp.playSE(11);
        	}
        }
        if (code == KeyEvent.VK_A) {
        	if (gp.ui.npcSlotCol != 0) {
            	gp.ui.npcSlotCol--;
            	gp.playSE(11);
        	}
        }
        if (code == KeyEvent.VK_S) {
        	if (gp.ui.npcSlotRow != 3) {
        		gp.ui.npcSlotRow++;
            	gp.playSE(11);
        	}
        }
        if (code == KeyEvent.VK_D) {
        	if (gp.ui.npcSlotCol != 4) {
            	gp.ui.npcSlotCol++;
            	gp.playSE(11);
        	}
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }
        if (code == KeyEvent.VK_X) {
            XPressed = false;
        }
        if (code == KeyEvent.VK_Q) { 
            QPressed = false;
        }
        if (code == KeyEvent.VK_F) { 
            shotKeyPressed = false;
        }
    }
}
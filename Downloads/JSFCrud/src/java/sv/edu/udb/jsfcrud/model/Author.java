/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.jsfcrud.model;
import java.util.Date;
public class Author {
 private int authorId;
 private String authorName;
 private Date authorBirth;
 private String authorNumber;
 private String literaryGenre;

 //generar constructor con parámetros y sin parámetros con ayuda del ide


 public Author() {
 }
 public Author(int authorId, String authorName, Date authorAge,
 String authorNumber, String literaryGenre) {
 this.authorId = authorId;
 this.authorName = authorName;
 this.authorBirth = authorAge;
 this.authorNumber = authorNumber;
 this.literaryGenre = literaryGenre;
 }

 //generar setters y getters con ayuda del ide.
 /**
 * @return the authorId
 */
 public int getAuthorId() {
 return authorId;
 }
 /**
 * @param authorId the authorId to set
 */
 public void setAuthorId(int authorId) {
 this.authorId = authorId;
 }
 /**
 * @return the authorName
 */
 public String getAuthorName() {
 return authorName;
 }
 /**
 * @param authorName the authorName to set
 */
 public void setAuthorName(String authorName) {
 this.authorName = authorName;
 }
 /**
 * @return the authorBirth
 */
 public Date getAuthorBirth() {
 return authorBirth;
 }
 /**
 * @param authorBirth the authorBirth to set
 */
 public void setAuthorBirth(Date authorBirth) {
 this.authorBirth = authorBirth;
 }
 /**
 * @return the authorNumber
 */
 public String getAuthorNumber() {
 return authorNumber;
 }
 /**
 * @param authorNumber the authorNumber to set
 */
 public void setAuthorNumber(String authorNumber) {
 this.authorNumber = authorNumber;
 }
 /**
 * @return the literaryGenre
 */
 public String getLiteraryGenre() {
 return literaryGenre;
 }
 /**
 * @param literaryGenre the literaryGenre to set
 */
 public void setLiteraryGenre(String literaryGenre) {
 this.literaryGenre = literaryGenre;
 }



}
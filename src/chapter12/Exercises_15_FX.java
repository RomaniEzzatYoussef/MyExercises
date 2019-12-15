package chapter12;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercises_15_FX  extends Application
{
	
	Label label1 , label2;
	TextField textField;
	
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		primaryStage.setTitle("Exercise_15");
		
		label1 = new Label("Enter the size of the list: ");
		textField = new TextField();
		textField.setPromptText("Enter the size of the list: ");
		Button button = new Button("Start");
		label2 = new Label("Label2");
		label2.setPadding(new Insets(20,20,20,20));

		button.setOnAction(e -> {
			try {
				createMyFile();
				label1.setText("I am clicked");
			} catch (IOException ex) {
				label2.setText(ex.getMessage());
			}
		});
		
		VBox vbox = new VBox(10);
		vbox.setPadding(new Insets(20 , 20 ,20, 20));
		vbox.getChildren().addAll(label1 , textField , button , label2);
		
		Scene scene = new Scene(vbox , 900 , 500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void createMyFile() throws IOException
	{
		File fileName = new File("E:\\work\\IntelliJ IDEA Projects\\MyExercises\\RomaniFiles\\chp12_e15.txt");
		
		if (!fileName.exists())
		{
			label2.setText("File does not exist, creating file..");
			fileName.createNewFile();
		}
		
		try (PrintWriter writer = new PrintWriter(fileName);)
		{
			writer.println("UnSorted Numbers: \n");
			Random randNumbers = new Random();
			label2.setText("Enter the size of the list: ");
			if (isInt(textField.getText()))
			{
				int size = Integer.parseInt(textField.getText());
				ArrayList<Integer> list = new ArrayList<>();

				for (int i = 1; i <= size; i++)
				{
					int num = randNumbers.nextInt(size);

					if (i % 10 == 0)
					{
						writer.println(num);
						list.add(num);
					}
					else
					{
						writer.print(num + " ");
						list.add(num);
					}

				}

				String fileContent = "";
				writer.println("\nSorted Numbers: \n");

				sort(list);


				for (int i = 0; i < list.size(); i++)
				{
					if ((i+1) % 10 == 0)
					{
						writer.println(list.get(i));
						fileContent += "\n" + list.get(i);
					}
					else
					{
						writer.print(list.get(i) + " ");
						fileContent += list.get(i) + " ";
					}

				}


			label2.setText(fileContent);
				writer.close();
			}
			
			
		}
		catch (Exception ex)
		{
			label2.setText(ex.getMessage());
		}

	
	}
	
	public static void sort(ArrayList<Integer> list)
	{
		for (int i = 0; i < list.size() - 1; i++)
		{
			int min = i;
			
			for (int j = i + 1; j < list.size(); j++)
				if (list.get(min) > list.get(j))
					min = j;
			
			if (min != i)
				swap(list, i, min);
		}
	}
	
	public static void swap(ArrayList<Integer> list, int curIndex, int minIndex)
	{
		int tempNum = list.get(curIndex);
		list.set(curIndex, list.get(minIndex));
		list.set(minIndex, tempNum);
	}
	
	public boolean isInt(String text)
	{
		try {
			Integer.parseInt(text);
			return true;
		} catch (Exception e) {
			label2.setText("Error " + text + " is not a number");
			return false;
		}
	}

}

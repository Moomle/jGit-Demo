package org.ffof.jgit;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String gitpath = "/Users/ZYP/Work/PythonSpace/guava/.git";
			Repository gitRepo = FileRepositoryBuilder.create(new File(gitpath));
			Ref master = gitRepo.findRef("master");
			System.out.println(master.getName());
			ObjectId masterId = master.getObjectId();
			RevWalk walk = new RevWalk(gitRepo);
			RevCommit mastercmt = walk.parseCommit(masterId);
			System.out.println(new String(mastercmt.getRawBuffer()));
			System.out.println(mastercmt.getShortMessage());
			RevCommit cmt = walk.next();
			while(cmt != null){
				System.out.println(cmt.getName());
				cmt = walk.next();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

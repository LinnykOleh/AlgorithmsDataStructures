package com.learning.linnyk.sp;

import javax.annotation.PostConstruct;

import com.learning.linnyk.sp.part1.Quoter;
import com.learning.linnyk.sp.part1.annotations.DeprecatedClass;
import com.learning.linnyk.sp.part1.annotations.InjectRandomInt;
import com.learning.linnyk.sp.part1.annotations.PostProxy;
import com.learning.linnyk.sp.part1.annotations.Profiling;
import com.learning.linnyk.sp.part2.T1000;

/**
 * @author LinnykOleh
 */
@Profiling
@DeprecatedClass(newImpl = T1000.class)
public class TerminatorQuoter implements Quoter {

	@InjectRandomInt(min = 2, max = 7)
	private int repeat;

	private String message;

	public TerminatorQuoter() {
		System.out.println("Phase 1");
		System.out.println(repeat);
	}

	@PostConstruct
	public void init(){
		System.out.println("Phase 2");
		System.out.println(repeat);
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setRepeat(int repeat) {
		this.repeat = repeat;
	}

	@Override
	@PostProxy
	public void sayQuote() {
		System.out.println("Phase 3");
		for (int i = 0; i < repeat; i++){
			System.out.println("message = " + message);
		}
	}
}